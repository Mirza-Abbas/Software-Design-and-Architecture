class singletonFile {
    private static singletonFile instance = null;
    String singletonData;

    private singletonFile(){}

    public static singletonFile getInstance(){
        
        if(instance == null){
            instance = new singletonFile();
        }

        return instance;
    }


    //setter method for Singleton data
    public void setSingletonData(String data){
        this.singletonData = data;
    }

    public String getSingletonData(){
        return this.singletonData;
    }

}

class Task1{
    public static void main(String[] args) {
        singletonFile s1=singletonFile.getInstance();
        singletonFile s2=singletonFile.getInstance();

        System.out.println(s1);
        s1.setSingletonData("My Files");
        System.out.println(s1.getSingletonData());

        System.out.println(s2);
        System.out.println(s2.getSingletonData());

    }
}