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
		String poemContent = "This is poem line1"
				+ System.getProperty("line.separator")
				+ "This is poem line2";

		// when
		new Poem(poemContent, poemParser);

		// then
		verify(poemParser).parsePoem(poemContent);
	}

	@Test
	public void shouldReadAndParsePoemUponConstruction() {
		// given
		PoemParser poemParser = mock(PoemParser.class);
		PoemReader poemReader = mock(PoemReader.class);
		String poemFilePath = "/tmp/poem.txt";
		String poemContent = "This is poem line1"
				+ System.getProperty("line.separator")
				+ "This is poem line2";
		stub(poemReader.readContent(poemFilePath)).toReturn(poemContent);

		// when
		new Poem(poemFilePath, poemReader, poemParser);

		// then
		verify(poemReader).readContent(poemFilePath);
		verify(poemParser).parsePoem(poemContent);
	}

	@Test
	public void shouldProvidePoemLinesInOrder() {
		// given
		PoemParser poemParser = mock(PoemParser.class);
		String poemContent = "This is poem line1"
				+ System.getProperty("line.separator")
				+ "This is poem line2";
		List<PoemLine> expectedLines = Arrays.asList(
				new PoemLine("This is poem line1"),
				new PoemLine("This is poem line2")
		);
		stub(poemParser.parsePoem(poemContent)).toReturn(expectedLines);

		// when
		Poem poem = new Poem(poemContent, poemParser);
		List<PoemLine> actualLines = poem.poemLines();

		// then
		assertThat(expectedLines, is(actualLines));
	}

	@Test
	public void shouldReturnTrueWhenPoemIsAnagrammatic() {
		// given
		PoemParser poemParser = mock(PoemParser.class);
		String poemContent = "A hard, howling, tossing water scene."
				+ System.getProperty("line.separator")
				+ "Strong tide was washing hero clean."
				+ System.getProperty("line.separator")
				+ "\"How cold!\" Weather stings as in anger."
				+ System.getProperty("line.separator")
				+ "O Silent night shows war ace danger!";
		List<PoemLine> expectedLines = Arrays.asList(
				new PoemLine("A hard, howling, tossing water scene."),
				new PoemLine("Strong tide was washing hero clean."),
				new PoemLine("\"How cold!\" Weather stings as in anger."),
				new PoemLine("O Silent night shows war ace danger!")
		);
		stub(poemParser.parsePoem(poemContent)).toReturn(expectedLines);

		// when
		Poem poem = new Poem(poemContent, poemParser);

		//then
		assertThat(poem.isAnagrammatic(), is(true));
	}

	@Test
	public void shouldReturnTrueWhenReadFromFileAndPoemIsAnagrammatic() {
		Poem poem = new Poem("anagrammatic-poem.txt", new ClasspathFilePoemReader(), new PoemParser());
		assertThat(poem.isAnagrammatic(), is(true));
	}

	@Test
	public void shouldReturnFalseWhenPoemIsNotAnagrammatic() {
		// given
		PoemParser poemParser = mock(PoemParser.class);
		String poemContent = "Said the little boy, \"Sometimes I drop my spoon.\""
				+ System.getProperty("line.separator")
				+ "Said the old man, \"I do that too.\""
				+ System.getProperty("line.separator")
				+ "The little boy whispered, \"I wet my pants.\""
				+ System.getProperty("line.separator")
				+ "\"I do that too,\" laughed the little old man.";
		List<PoemLine> expectedLines = Arrays.asList(
				new PoemLine("Said the little boy, \"Sometimes I drop my spoon.\""),
				new PoemLine("Said the old man, \"I do that too.\""),
				new PoemLine("The little boy whispered, \"I wet my pants.\""),
				new PoemLine("\"I do that too,\" laughed the little old man.")
		);
		stub(poemParser.parsePoem(poemContent)).toReturn(expectedLines);

		// when
		Poem poem = new Poem(poemContent, poemParser);

		//then
		assertThat(poem.isAnagrammatic(), is(false));
	}

	@Test
	public void shouldReturnFalseWhenReadFromFileAndPoemIsNotAnagrammatic() {
		Poem poem = new Poem("non-anagrammatic-poem.txt", new ClasspathFilePoemReader(), new PoemParser());
		assertThat(poem.isAnagrammatic(), is(false));
	}

}
