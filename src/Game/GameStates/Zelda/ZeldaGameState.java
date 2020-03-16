package Game.GameStates.Zelda;

import Game.GameStates.State;
import Game.Zelda.Entities.Dynamic.Direction;
import Game.Zelda.Entities.Dynamic.Link;
import Game.Zelda.Entities.Statics.SectionDoor;
import Game.Zelda.Entities.Statics.SolidStaticEntities;
import Main.Handler;
import Resources.Images;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by AlexVR on 3/14/2020
 */
public class ZeldaGameState extends State {


    public static int xOffset,yOffset,stageWidth,stageHeight,worldScale;
    public int cameraOffsetX,cameraOffsetY;
    //map is 16 by 7 squares, you start at x=7,y=7 starts counting at 0
    public int mapX,mapY,mapWidth,mapHeight;

    public ArrayList<ArrayList<ArrayList<SolidStaticEntities>>> objects;
    public Link link;



    public ZeldaGameState(Handler handler) {
        super(handler);
        xOffset = handler.getWidth()/4;
        yOffset = handler.getHeight()/4;
        stageWidth = handler.getWidth()/3 + (handler.getWidth()/15);
        stageHeight = handler.getHeight()/2;
         worldScale = 3;
         mapX = 7;
         mapY = 7;
         mapWidth = 256;
         mapHeight = 176;
         cameraOffsetX =  ((mapWidth*mapX) + mapX + 1)*worldScale;
         cameraOffsetY = ((mapHeight*mapY) + mapY + 1)*worldScale;
         objects = new ArrayList<>();
         for (int i =0;i<16;i++){
             objects.add(new ArrayList<>());
             for (int j =0;j<8;j++) {
                 objects.get(i).add(new ArrayList<>());
             }
         }
         addWorldObjects();

         link = new Link(xOffset+(stageWidth/2),yOffset + (stageHeight/2),Images.zeldaLinkFrames,handler);


    }



    @Override
    public void tick() {
        link.tick();
        if (!link.movingMap) {
            for (SolidStaticEntities entity : objects.get(mapX).get(mapY)) {
                entity.tick();
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.zeldaMap,-cameraOffsetX + xOffset,-cameraOffsetY + yOffset,Images.zeldaMap.getWidth()*worldScale,Images.zeldaMap.getHeight()*worldScale,null );
        if (!link.movingMap) {
            for (SolidStaticEntities entity : objects.get(mapX).get(mapY)) {
                entity.render(g);
            }
        }
        link.render(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,xOffset,handler.getHeight());
        g.fillRect(xOffset+stageWidth ,0,handler.getWidth(),handler.getHeight());
        g.fillRect(0,0,handler.getWidth(),yOffset);
        g.fillRect(0,yOffset+stageHeight,handler.getWidth(),handler.getHeight());

    }

    private void addWorldObjects() {
        ArrayList<SolidStaticEntities> doors = new ArrayList<>();
        doors.add(new SectionDoor( 0,5,16*worldScale,16*worldScale, Direction.LEFT,handler));
        doors.add(new SectionDoor( 7,0,16*worldScale * 2,16*worldScale,Direction.UP,handler));
        doors.add(new SectionDoor( 15,5,16*worldScale,16*worldScale,Direction.RIGHT,handler));
        doors.add(new SolidStaticEntities(6,0,Images.forestTiles.get(2),handler));
        doors.add(new SolidStaticEntities(5,1,Images.forestTiles.get(5),handler));
        doors.add(new SolidStaticEntities(6,1,Images.forestTiles.get(6),handler));
        doors.add(new SolidStaticEntities(3,2,Images.forestTiles.get(6),handler));
        doors.add(new SolidStaticEntities(2,3,Images.forestTiles.get(6),handler));
        doors.add(new SolidStaticEntities(1,4,Images.forestTiles.get(6),handler));
        doors.add(new SolidStaticEntities(1,6,Images.forestTiles.get(3),handler));
        doors.add(new SolidStaticEntities(1,7,Images.forestTiles.get(5),handler));
        doors.add(new SolidStaticEntities(1,8,Images.forestTiles.get(5),handler));
        doors.add(new SolidStaticEntities(2,9,Images.forestTiles.get(2),handler));
        doors.add(new SolidStaticEntities(3,9,Images.forestTiles.get(2),handler));
        doors.add(new SolidStaticEntities(4,9,Images.forestTiles.get(2),handler));
        doors.add(new SolidStaticEntities(5,9,Images.forestTiles.get(2),handler));
        doors.add(new SolidStaticEntities(6,9,Images.forestTiles.get(2),handler));
        doors.add(new SolidStaticEntities(7,9,Images.forestTiles.get(2),handler));
        doors.add(new SolidStaticEntities(8,9,Images.forestTiles.get(2),handler));
        doors.add(new SolidStaticEntities(9,9,Images.forestTiles.get(2),handler));
        doors.add(new SolidStaticEntities(10,9,Images.forestTiles.get(2),handler));
        doors.add(new SolidStaticEntities(11,9,Images.forestTiles.get(2),handler));
        doors.add(new SolidStaticEntities(12,9,Images.forestTiles.get(2),handler));
        doors.add(new SolidStaticEntities(13,9,Images.forestTiles.get(2),handler));
        doors.add(new SolidStaticEntities(14,8,Images.forestTiles.get(5),handler));
        doors.add(new SolidStaticEntities(14,7,Images.forestTiles.get(5),handler));
        doors.add(new SolidStaticEntities(14,6,Images.forestTiles.get(2),handler));
        doors.add(new SolidStaticEntities(14,4,Images.forestTiles.get(5),handler));
        doors.add(new SolidStaticEntities(13,4,Images.forestTiles.get(5),handler));
        doors.add(new SolidStaticEntities(12,4,Images.forestTiles.get(5),handler));
        doors.add(new SolidStaticEntities(11,4,Images.forestTiles.get(5),handler));
        doors.add(new SolidStaticEntities(10,4,Images.forestTiles.get(5),handler));
        doors.add(new SolidStaticEntities(9,4,Images.forestTiles.get(4),handler));
        doors.add(new SolidStaticEntities(9,3,Images.forestTiles.get(5),handler));
        doors.add(new SolidStaticEntities(9,2,Images.forestTiles.get(5),handler));
        doors.add(new SolidStaticEntities(9,1,Images.forestTiles.get(5),handler));
        doors.add(new SolidStaticEntities(9,0,Images.forestTiles.get(5),handler));
        objects.get(7).set(7,doors);

        doors = new ArrayList<>();
        doors.add(new SectionDoor( 0,2,16*worldScale,16*worldScale*7, Direction.LEFT,handler));
        doors.add(new SectionDoor( 12,0,16*worldScale * 2,16*worldScale,Direction.UP,handler));
        doors.add(new SectionDoor( 15,5,16*worldScale,16*worldScale,Direction.RIGHT,handler));
        objects.get(6).set(7,doors);

        doors = new ArrayList<>();
        doors.add(new SectionDoor( 0,4,16*worldScale,16*worldScale*3, Direction.LEFT,handler));
        doors.add(new SectionDoor( 7,10,16*worldScale * 2,16*worldScale,Direction.DOWN,handler));
        doors.add(new SectionDoor( 15,4,16*worldScale,16*worldScale*3,Direction.RIGHT,handler));
        objects.get(7).set(6,doors);

        doors = new ArrayList<>();
        doors.add(new SectionDoor( 0,5,16*worldScale,16*worldScale, Direction.LEFT,handler));
        doors.add(new SectionDoor( 2,0,16*worldScale * 13,16*worldScale,Direction.UP,handler));
        doors.add(new SectionDoor( 15,2,16*worldScale,16*worldScale*7,Direction.RIGHT,handler));
        objects.get(8).set(7,doors);
    }

    @Override
    public void refresh() {

    }
}
