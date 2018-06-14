package com.itrexgroup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveSymbolsTest {

    @Test
    public void checkRemoveLetterC() {
        String success = RemoveSymbols.getInstance().removeLetterC("success");
        assertEquals("Letter C wasn't deleted correctly", "suksess", success);
    }

    @Test
    public void checkRemoveDoubleLetter() {
        String oou = RemoveSymbols.getInstance().removeDoubleLetter("oou");
        assertEquals("Double letter wasn't deleted correctly", "u", oou);
    }

    @Test
    public void checkRemoveLetterE() {
        String the = RemoveSymbols.getInstance().removeLetterE("The");
        assertEquals("Letter E wasn't deleted correctly", "Th ", the);
    }

    @Test
    public void checkRemoveArticles() {
        String tabl = RemoveSymbols.getInstance().removeArticles("th tabl");
        assertEquals("Articles weren't deleted correctly", "tabl", tabl);
    }

    @Test
    public void finalTest() {
        String removeLetterC = RemoveSymbols.getInstance().removeLetterC("The cacao and coffee is a way to success.");
        String removeDoubleLetter = RemoveSymbols.getInstance().removeDoubleLetter(removeLetterC);
        String removeLetterE = RemoveSymbols.getInstance().removeLetterE(removeDoubleLetter);
        String removeArticles = RemoveSymbols.getInstance().removeArticles(removeLetterE);

        assertEquals("The text is not correct", " kakao and kofi isway to suks s.", removeArticles);
    }
}
