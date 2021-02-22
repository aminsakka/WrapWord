package wrapWord ;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static wrapWord.WrapWord.wrap;


public class WrapWordShould {

    public static final String EMPTY = "";

    @Test
    public void empty_string_should_return_empty_string(){
        //GIVEN
        final String input = EMPTY;

        final String expected = EMPTY;

        assertTrue(wrap(input , 5).equals(expected));
    }

    @Test
    public void should_no_wrap(){
        //GIVEN
        final String input = "HELLO" ;

        final String expected = "HELLO" ;

        assertTrue(wrap(input , 6).equals(expected));
    }

    @Test
    public void should_wrap_single_word(){
        //GIVEN
        final String input = "Hello" ;

        final String expected = "Hel\nlo" ;

        assertTrue(wrap(input , 3).equals(expected));
    }

    @Test
    public void should_wrap_single_word_twice(){
        //GIVEN
        final String input = "HelloHellohello" ;

        final String expected = "Hello\nHello\nhello" ;
        assertTrue(wrap(input, 5).equals(expected));
    }

    @Test
    public void should_wrap_two_words_space_on_break(){
        //GIVEN
        final String input = "Hello Hello" ;

        final String expected = "Hello\nHello" ;
        assertTrue(wrap(input, 6).equals(expected));
    }

    @Test
    public void should_wrap_two_words_space_before_break(){
        //GIVEN
        final String input = "Hello Hello" ;

        final String expected = "Hello\nHello" ;
        assertTrue(wrap(input, 7).equals(expected));
    }

    @Test
    public void should_wrap_two_words_space_after_break(){
        //GIVEN
        final String input = "Hello Hello" ;

        final String expected = "Hello\nHello" ;
        assertTrue(wrap(input, 5).equals(expected));
    }

    @Test
    public void word_word_5_should_break(){
        //GIVEN
        final String input = "Word word" ;

        final String expected = "Word\nword" ;
        assertTrue(wrap(input, 5).equals(expected));
    }


    @Test
    public void should_split_number(){
        //GIVEN
        final String input = "123456789" ;

        final String expected = "123456\n789" ;
        assertTrue(wrap(input,6).equals(expected));
    }

    @Test
    public void should_break_into_many_lines(){
        //GIVEN
        final String input = "Hello Hello hello" ;

        final String expected = "Hell\no\nHell\no\nhell\no" ;

        assertTrue(wrap(input, 4).equals(expected));
    }

    @Test
    public void should_break_into_many_lines2(){
        //GIVEN
        final String input = "Hello Hello" ;

        final String expected = "Hello\nHello" ;

        assertTrue(wrap(input, 9).equals(expected));
    }
}
