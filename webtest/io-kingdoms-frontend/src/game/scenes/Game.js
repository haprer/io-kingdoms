import { EventBus } from '../EventBus';
import { Scene } from 'phaser';

import Tile from '../objects/Tile';

export class Game extends Scene
{
    constructor ()
    {
        super('Game');
    }

    preload()  { 
        
    }

    create ()
    {
        this.cameras.main.setBackgroundColor(0x00ff00);

        //create the background grid. 
        const TILE_SIZE = 32;
        const GRID_SIZE = 32;
    
        // Initialize the tiles array with empty arrays
        for (let i = 0; i < GRID_SIZE; i++) {
          this.tiles[i] = [];
        }
    
        for (let i = 0; i < GRID_SIZE; i++) {
          for (let j = 0; j < GRID_SIZE; j++) {
            const x = i * TILE_SIZE;
            const y = j * TILE_SIZE;
            const tile = new Tile(this, x, y);
            this.add.existing(tile);
            this.tiles[i][j] = tile; // Save the tile object in the array
          }
        }

        //define camera motions 
        this.input.on('pointerdown', (pointer) => {
            this.input.dragStartX = pointer.x;
            this.input.dragStartY = pointer.y;
        });
        this.input.on('pointermove', (pointer) => {
            if (pointer.isDown) {
              this.cameras.main.scrollX -= (pointer.x - this.input.dragStartX)
              this.cameras.main.scrollY -= (pointer.y - this.input.dragStartY) 
              this.input.dragStartX = pointer.x;
              this.input.dragStartY = pointer.y; 
            }
        });


        EventBus.emit('current-scene-ready', this);
    }

    changeScene ()
    {
        this.scene.start('GameOver');
    }
}
