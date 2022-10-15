package com.skeletor.scoreboard;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    int playerOneScore = 0;
    int playerTwoScore = 0;
    Player player1 = new Player(playerOneScore);
    Player player2 = new Player(playerTwoScore);

    @RequestMapping("/reset")
    public ModelAndView reset() {
        playerOneScore = 0;
        playerTwoScore = 0;
        return new ModelAndView("redirect:/score");
    }

    @RequestMapping("/addPlayer2")
    public ModelAndView addPlayerTwo() {
        playerTwoScore++;
        return new ModelAndView("redirect:/score");
    }

    @RequestMapping("/addPlayer1")
    public ModelAndView addPlayerOne() {
        playerOneScore++;
        return new ModelAndView("redirect:/score");
    }

    @RequestMapping("/score")
    public ModelAndView hello() {
        Map<String, Object> map = new HashMap<>();
        player1.setScore(playerOneScore);
        player2.setScore(playerTwoScore);
        map.put("player1", player1);
        map.put("player2", player2);
        if (playerOneScore >= 11 || playerTwoScore >= 11) {
            sendPayloadWin();
            return new ModelAndView("winner", map);
        }
        sendPayload();

        return new ModelAndView("scoreboard", map);
    }

    public void sendPayload() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://ticker.local/api");
        String JSON_STRING = String.format("[{\"text\": \"%s\", \"color\": \"00FF00\", \"size\": 3, \"x\": 1, \"y\": 15, \"align\": \"L\"},{\"text\": \"%s\", \"color\": \"0000FF\", \"size\": 3, \"x\": 62, \"y\": 15, \"align\": \"R\"}]", playerOneScore, playerTwoScore);
        HttpEntity stringEntity = new StringEntity(JSON_STRING, ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);
        try {
            CloseableHttpResponse response2 = httpclient.execute(httpPost);
        } catch (Exception e) {
            System.out.println("");
        }

    }

    public void sendPayloadWin() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://ticker.local/api");
        String JSON_STRING = String.format("[{\"text\": \"WIN\", \"color\": \"FF0000\", \"size\": 2, \"x\":25, \"y\": 24, \"align\": \"L\"},{\"text\": \"%s\", \"color\": \"00FF00\", \"size\": 3, \"x\": 1, \"y\": 15, \"align\": \"L\"},{\"text\": \"%s\", \"color\": \"0000FF\", \"size\": 3, \"x\": 62, \"y\": 15, \"align\": \"R\"}]", playerOneScore, playerTwoScore);
        HttpEntity stringEntity = new StringEntity(JSON_STRING, ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);
        try {
            CloseableHttpResponse response2 = httpclient.execute(httpPost);
        } catch (Exception e) {
            System.out.println("");
        }

    }
}
