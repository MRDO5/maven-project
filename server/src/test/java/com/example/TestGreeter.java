package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TestGreeter {

    private Greeter greeter;

    @BeforeEach
    void setUp() {
        greeter = new Greeter();
    }

    @Test
    void shouldReturnGreetingMessage() {
        String message = greeter.greet("Martin");
        assertThat(message, containsString("Martin"));
    }

    @Test
    void shouldReturnNonEmptyMessage() {
        String message = greeter.greet("World");
        assertThat(message.length(), org.hamcrest.Matchers.greaterThan(0));
    }
}
