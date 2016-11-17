/* Filename: PSA5.java 
* Created by: Nick Lin, Robert Tso, CS8a
* Date: 11/3/16
*/ 
import java.awt.Color;
public class PSA5
{ 
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args) 
    { 
     Picture myselfSourceImage = new Picture(FileChooser.pickAFile());
     Picture myBackgroundSourceImage = new Picture(FileChooser.pickAFile());
     Picture myShirtSourceImage =new Picture(FileChooser.pickAFile());
 
     Color greenScreen = new Color(85, 185, 165);
     Color redShirt = new Color(200,60,80);
     myselfSourceImage.explore();
      
     Picture myChangedBackgroundImage = myselfSourceImage.chromakeyBackgroundChange(myBackgroundSourceImage,greenScreen);
     myChangedBackgroundImage.explore();
      
     Picture myFinalImage = myChangedBackgroundImage.chromakeyShirtChange(myShirtSourceImage,myselfSourceImage,redShirt,342,133,240,353);
      myFinalImage.explore();
    } 
}
