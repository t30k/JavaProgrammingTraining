package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.text.ParseException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(Enclosed.class)
public class MemberCertificationTest {

    private static MemberCertification certification;

    @Before
    public void setup() {
        certification = new MemberCertification();
    }

    static class Fixture {
        String value; // テストデータ
        boolean expected; // 期待値

        Fixture(String value, boolean expected) {
            this.value = value;
            this.expected = expected;
        }
    }

    @RunWith(Theories.class)
    public static class 生年月日_正しい場合 {
        @DataPoints
        public static Fixture[] FIXTURES = {
                new Fixture("1990/1/1", true),
                new Fixture("1990/01/01", true)
        };

        @Theory
        public void checkBirthday_生年月日が正しい場合はtrueが返却される(Fixture fixture) throws Exception {
            boolean actual = certification.checkBirthday(fixture.value);
            boolean expected = fixture.expected;

            assertThat(actual, is(expected));
        }
    }

    @RunWith(Theories.class)
    public static class 生年月日_不正な場合 {
        @DataPoints
        public static Fixture[] FIXTURES = {
                new Fixture("1990/1/2", false),
                new Fixture("1990/01/02", false)
        };

        @Theory
        public void checkBirthday_生年月日が不正な場合はfalseが返却される(Fixture fixture) throws Exception {
            boolean actual = certification.checkBirthday(fixture.value);
            boolean expected = fixture.expected;

            assertThat(actual, is(expected));
        }
    }

    @RunWith(Theories.class)
    public static class 生年月日_型違い_例外発生 {
        @DataPoints
        public static Fixture[] FIXTURES = {
                new Fixture("199011", false),
                new Fixture("", false)
        };

        @Theory
        @Test(expected = ParseException.class)
        public void checkBirthday_生年月日がキャスト不能な場合は例外を送出する(Fixture fixture) throws Exception {
            certification.checkBirthday(fixture.value);
        }
    }
}
