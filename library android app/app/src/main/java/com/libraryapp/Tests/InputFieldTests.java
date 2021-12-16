package com.libraryapp.Tests;

import com.libraryapp.Utilities.InputFieldValidator;
import org.junit.Assert;
import org.junit.Test;

public class InputFieldTests {

    @Test
    public void InputFieldValidatorShouldReturnTrueWhenPassedAnEmptyString() {
        Assert.assertTrue(InputFieldValidator.fieldIsEmpty(""));
    }

    @Test
    public void InputFieldValidatorShouldReturnTrueWhenPassedStringWithSpace() {
        Assert.assertTrue(InputFieldValidator.fieldIsEmpty("     "));
    }

    @Test
    public void InputFieldValidatorShouldReturnFlaseWhenPassedTextString() {
        Assert.assertFalse(InputFieldValidator.fieldIsEmpty("something"));
    }
}
