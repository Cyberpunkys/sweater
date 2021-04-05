package com.example.sweater.domain.util;

import com.example.sweater.domain.User;

public final class MessageHelper {

    private MessageHelper() { }

    public static String getAuthorName(User author) {
        return author != null ? author.getUsername() : "<none>";
    }
}
