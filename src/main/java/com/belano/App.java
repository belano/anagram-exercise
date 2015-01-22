package com.belano;

/**
 * Main app
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "--Anagrammatic poem detector--" );
		if (args.length != 1) {
			System.out.println("This program expects an absolute path for the poem to be checked");
			System.exit(0);
		}

		String path = args[0];
		Poem poem = new Poem(path, new FileSystemPoemReader(), new PoemParser());
		boolean isAnagrammatic = poem.isAnagrammatic();
		if (isAnagrammatic) {
			System.out.println("True - Your poem was detected as anagrammatic");
		} else {
			System.out.println("False - Your poem was detected as NON anagrammatic");
		}
	}

}
