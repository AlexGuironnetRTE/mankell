package org.mankell.operatorfabric;

import org.lfenergy.operatorfabric.cards.model.*;
import org.mankell.model.iss.ISSPassesReport;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;

@Service
public class CardPublisher {

    public Card createISSCard(ISSPassesReport issPassesReport) {

        Card card = new Card();

        String process = "passes_process";

        card.setProcess(process);
        card.setProcessId(process+issPassesReport.getRequest().getLatitude()+"_"+issPassesReport.getRequest().getLongitude());
        card.setPublisher("ISS"); //TODO Create ISS Bundle
        card.setPublisherVersion("1");

        card.setLttd(Instant.now().toEpochMilli());
        card.setStartDate(Instant.now().toEpochMilli());
        card.setEndDate(Instant.now().toEpochMilli() + 2*60*60*1000);

        card.setSeverity(SeverityEnum.ACTION);

        Recipient adminUser = new Recipient();
        adminUser.setType(RecipientEnum.USER);
        adminUser.setIdentity("admin");
        card.setRecipient(adminUser);

        I18n i18nTitle = new I18n();
        i18nTitle.setKey(process+".title");
        HashMap<String,String> i18nTitleParams = new HashMap<>();
        i18nTitleParams.put("value","LAT "+issPassesReport.getRequest().getLatitude()+" LON "+issPassesReport.getRequest().getLongitude());
        i18nTitle.setParameters(i18nTitleParams);
        card.setTitle(i18nTitle);

        I18n i18nSummary = new I18n();
        i18nSummary.setKey(process+".summary");
        HashMap<String,String> i18nSummaryParams = new HashMap<>();
        i18nSummaryParams.put("value",issPassesReport.getMessage());
        i18nSummary.setParameters(i18nSummaryParams);
        card.setSummary(i18nSummary);

        card.setState("firstState");

        card.setData(issPassesReport);

        return card;
    }

    public CardCreationReport publishCard(Card card) {

        String uri = "http://localhost:2102/cards";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        /*
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");*/

        HttpEntity<Card> request = new HttpEntity<>(card, headers);

        RestTemplate restTemplate = new RestTemplate();
        CardCreationReport result = restTemplate.postForObject(uri, request, CardCreationReport.class);

        return result;

    }

}
