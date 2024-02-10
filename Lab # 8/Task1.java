interface MediaPlayer{
    public void Play(String FileName, String FileExtension);
}

class MediaAdapter implements MediaPlayer{

    public void Play(String FileName, String FileExtension){

      if(FileExtension.equalsIgnoreCase("mp4") ){
        VideoPlayer v1 = new VideoPlayer();
        v1.PlayVideo(FileName);	
         
      }else if (FileExtension.equalsIgnoreCase("mp3")){
        AudioPlayer a1 = new AudioPlayer();
        a1.PlayMusic(FileName);
      }	
   }
}

class AudioPlayer{
    void PlayMusic(String FileName){
        System.out.println("Playing Music: " + FileName);
    }
}

class VideoPlayer{
    void PlayVideo(String FileName){
        System.out.println("Playing Video: " + FileName);
    }
}

class Task1{
    public static void main(String[] args) {
        String FileName = "Song XYZ";
        String FileExtension = "mp3";

        MediaPlayer m1 = new MediaAdapter();
        m1.Play(FileName, FileExtension);
    }
}