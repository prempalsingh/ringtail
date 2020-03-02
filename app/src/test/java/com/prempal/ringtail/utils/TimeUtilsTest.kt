package com.prempal.ringtail.utils

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

/**
 * Created by prempal on 3/2/20.
 */
class TimeUtilsTest {

    @Test
    fun convertTime_defaultFormatters_ISO8601Input() {
        assertThat(convertTime("2016-04-17T14:28:06Z"), `is`("17/04/16 14:28"))
    }

    @Test
    fun convertTime_unparseableInput_returnsInput() {
        assertThat(convertTime("abcd"), `is`("abcd"))
    }
}
