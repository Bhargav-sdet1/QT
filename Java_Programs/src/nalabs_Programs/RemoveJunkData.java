package nalabs_Programs;

public class RemoveJunkData {

	public static void main(String[] args) {
		
		String str="#@$%^&*((*&^ghjdfsdjhef12346789";
		
		str=str.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(str);

	}

}
