package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void appleTest() throws Exception {
        assertThat(queryProcessor.process("apple"), containsString("apppppple"));
    }

    @Test
    public void teamNameTest() throws Exception {
        assertThat(queryProcessor.process("what is your team name"), containsString("lcq"));
    }

    @Test
    public void plusTest() throws Exception {
        assertThat(queryProcessor.process("what is 20 plus 25"), containsString("45"));
        assertThat(queryProcessor.process("what is 100 plus 200"), containsString("300"));

    }

    @Test
    public void mulTest() throws Exception {
        assertThat(queryProcessor.process("what is 20 multiplied by 25"), containsString("500"));

    }


    @Test
    public void minusTest() throws Exception {
        assertThat(queryProcessor.process("what is 20 minus 25"), containsString("-5"));

    }
}
