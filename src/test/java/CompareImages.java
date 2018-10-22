

import bro.code.face.SearchFace;

import java.util.Map;


public class CompareImages {

	public static void main(String[] args) {
		
		String folderLocationToSearch="C:\\Users\\Hp\\Pictures\\test\\2";
		String sourceImage="C:\\Users\\Hp\\Pictures\\test\\devendra.jpg";
		float similarityThreshold=55f;
		
		SearchFace searchFace=new SearchFace(folderLocationToSearch, sourceImage, similarityThreshold);
		Map<String, Float> matchedImages=searchFace.run();
		
		
		System.out.println("DONE");
	}

}
