package com.virgingames.virgingameInfo;

import com.virgingames.testBase.TestBase;
import com.virgingames.virgingamesInfo.VirginGamesSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

@RunWith(SerenityRunner.class)
public class DefaultGamesFrequencyTest extends TestBase {

    @Steps
    VirginGamesSteps virginGamesSteps;

    @Title("Verify default Game frequency should be always 300000")
    @Test
    public void test001() {

        for (int i = 0; i < 10; i++) {
            String defaultFrequency = virginGamesSteps.getBingoLobbyInfo()
                    .extract()
                    .jsonPath()
                    .getString("bingoLobbyInfoResource.streams[" + i + "].defaultGameFrequency");
            System.out.println("Default Game Frequency : " + defaultFrequency);
            assertThat(defaultFrequency, equalTo("300000"));

        }
    }

    @Title("Start time should always be future timestamp")
    @Test
    public void test002() {

        long timeStamp = virginGamesSteps.getBingoLobbyInfo()
                .extract()
                .jsonPath()
                .getLong("timestamp");
        System.out.println("Current timestamp : "+timeStamp);

        for (int i=0;i<10;i++) {
            long startTime = virginGamesSteps.getBingoLobbyInfo()
                    .extract()
                    .jsonPath()
                    .getLong("bingoLobbyInfoResource.streams[" + i + "].startTime");
            System.out.println("Start time  : "+startTime);
            assertThat(startTime,greaterThan(timeStamp));

        }
    }
}
