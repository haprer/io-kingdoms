
import Phaser from "phaser";





//module consts 
export const WIDTH = 32; 



/**
 * A tile is the basic unit on the gameplay grid. 
 * 
 */
export default class Tile extends Phaser.GameObjects.Image { 



    /**
     * 
     * @param {Phaser.Scene} scene
     * @param {number} x
     * @param {number} y  
     */
    constructor(scene, x, y) { 
        super(scene, x, y, 'tile');
        this.setOrigin(0,0);
    }

    /**
     * @override
     */
    update() { 

    }



}