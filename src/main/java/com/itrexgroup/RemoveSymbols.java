package com.itrexgroup;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RemoveSymbols {

    private static final String SI = "si";
    private static final String SE = "se";
    private static final String K = "k";
    private static final String I = "i";
    private static final String U = "u";
    private static final RemoveSymbols INSTANCE = new RemoveSymbols();


    public String removeLetterC(String text) {
        text = text.replaceAll("[Cc][Ii]", SI);
        text = text.replaceAll("[Cc][Ee]", SE);
        text = text.replaceAll("[Cc][Kk]", K);
        text = text.replaceAll("[Cc]", K);

        return text;
    }

    public String removeDoubleLetter(String text) {
        text = text.replaceAll("[Ee][Ee]", I);
        text = text.replaceAll("[Oo][Oo]", U);

        Pattern pattern = Pattern.compile("(?<double>[a-z])\\k<double>");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            text = text.replaceFirst(pattern.toString(), matcher.group("double"));
        }

        return text;
    }

    public String removeLetterE(String text) {
        Pattern pattern = Pattern.compile("\\w+[e](\\s|$|,.!?)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            text = text.replace('e', ' ');
        }

        return text;
    }

    public String removeArticles(String text) {
        Pattern pattern = Pattern.compile("\\s*([Aa]|[Aa][n]|[Tt][h])\\s");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            text = matcher.replaceAll("");
        }

        return text;
    }

    public static RemoveSymbols getInstance() {
        return INSTANCE;
    }
}
