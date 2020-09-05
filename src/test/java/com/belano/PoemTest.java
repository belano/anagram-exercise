package com.belano;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

/**
 * Unit test for {@link com.belano.Poem} class
 */
public class PoemTest {

	@Test
	public void shouldParsePoemUponConstruction() {
		// given
		PoemParser poemParser = mock(PoemParser.class);
		String filePath = "poem.txt";

		// when
		new Poem(filePath, poemParser);

		// then
		verify(poemParser).parsePoem(filePath);
	}

	@Test
	public void shouldProvidePoemLinesInOrder() {
		// given
		PoemParser poemParser = mock(PoemParser.class);
		String filePath = "poem.txt";
		List<PoemLine> expectedLines = Arrays.asList(
				new PoemLine("This is poem line1"),
				new PoemLine("This is poem line2")
		);
		stub(poemParser.parsePoem(filePath)).toReturn(expectedLines);

		// when
		Poem poem = new Poem(filePath, poemParser);
		List<PoemLine> actualLines = poem.poemLines();

		// then
		assertThat(expectedLines, is(actualLines));
	}

	@Test
	public void shouldReturnTrueWhenPoemIsAnagrammatic() {
		// given
		PoemParser poemParser = mock(PoemParser.class);
		String filePath = "poem.txt";
		List<PoemLine> expectedLines = Arrays.asList(
				new PoemLine("A hard, howling, tossing water scene."),
				new PoemLine("Strong tide was washing hero clean."),
				new PoemLine("\"How cold!\" Weather stings as in anger."),
				new PoemLine("O Silent night shows war ace danger!")
		);
		stub(poemParser.parsePoem(filePath)).toReturn(expectedLines);

		// when
		Poem poem = new Poem(filePath, poemParser);

		//then
		assertThat(poem.isAnagrammatic(), is(true));
	}

	@Test
	public void shouldReturnTrueWhenReadFromFileAndPoemIsAnagrammatic() {
		Poem poem = new Poem("anagrammatic-poem.txt", new PoemParser(new ClasspathFilePoemReader()));
		assertThat(poem.isAnagrammatic(), is(true));
	}

	@Test
	public void shouldReturnFalseWhenPoemIsNotAnagrammatic() {
		// given
		PoemParser poemParser = mock(PoemParser.class);
		String filePath = "poem.txt";
		List<PoemLine> expectedLines = Arrays.asList(
				new PoemLine("Said the little boy, \"Sometimes I drop my spoon.\""),
				new PoemLine("Said the old man, \"I do that too.\""),
				new PoemLine("The little boy whispered, \"I wet my pants.\""),
				new PoemLine("\"I do that too,\" laughed the little old man.")
		);
		stub(poemParser.parsePoem(filePath)).toReturn(expectedLines);

		// when
		Poem poem = new Poem(filePath, poemParser);

		//then
		assertThat(poem.isAnagrammatic(), is(false));
	}

	@Test
	public void shouldReturnFalseWhenReadFromFileAndPoemIsNotAnagrammatic() {
		Poem poem = new Poem("non-anagrammatic-poem.txt", new PoemParser(new ClasspathFilePoemReader()));
		assertThat(poem.isAnagrammatic(), is(false));
	}

}
