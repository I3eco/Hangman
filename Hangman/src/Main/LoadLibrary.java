package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadLibrary {
	private List<String> lines;

	LoadLibrary(String category) {
		try {
			this.categoryToStringArr(category);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void categoryToStringArr(String category) throws IOException {
		this.lines = new ArrayList<String>();
		File f = new File("./Library");
		FileReader fileReader = new FileReader(f);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;

		while ((line = bufferedReader.readLine()) != null) {
			if (line.equalsIgnoreCase("_" + category)) {
				while ((line = bufferedReader.readLine()) != null) {
					if (line.charAt(0) == '_') {
						break;
					}
					lines.add(line);
				}

			}
		}
		bufferedReader.close();
	}

	public List<String> getLines() {
		return lines;
	}

	public static List<String> makeCategory() {
		List<String> lines = new ArrayList<String>();
		File f = new File("./Library");
		try {
			FileReader fileReader = new FileReader(f);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;

			while ((line = bufferedReader.readLine()) != null) {
				if (line.charAt(0) == '_') {
					lines.add(line.substring(1));
				}
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	public static void printCategories() {
		List<String> lines = makeCategory();

		for (int i = 0; i < lines.size(); i++) {
			System.out.println(lines.get(i));
		}
	}

	public static boolean checkCategory(String category) {
		List<String> lines = makeCategory();
		for (int i = 0; i < lines.size(); i++) {
			if (category.equalsIgnoreCase(lines.get(i))) {
				return true;
			}
		}
		return false;
	}

}
