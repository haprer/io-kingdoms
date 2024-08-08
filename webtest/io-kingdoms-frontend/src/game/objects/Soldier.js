
import Phaser from "phaser";




/**
 * A tile is the basic unit on the gameplay grid. 
 * 
 */
export default class Solder extends Phaser.GameObjects.Image { 



    /**
     * 
     * @param {Phaser.Scene} scene
     * @param {number} x
     * @param {number} y  
     */
    constructor(scene, x, y) { 
        super(scene, x, y, 'soldier');   //Set the image texture to key 'soldier'
         this.setOrigin(0,0); //upper left hand corner? 
    }
    
    

    /**
     * @override
     */
    update() { 

    }



}