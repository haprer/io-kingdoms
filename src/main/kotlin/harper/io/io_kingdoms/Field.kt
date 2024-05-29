package harper.io.io_kingdoms

object Field {
        //properties
        //private 2d array of type Int
        private var width: Int = 10
        private var height: Int = 10
        private var field: Array<Array<Square>>

        private val lock = Any()


    init {
        println("Field created")
        this.field  = Array(height) { Array(width) { Square() } }
    }

    /*
     * Function to get a square from the field
     */
    fun getSquare(x: Int, y: Int): Square {
        return field[x][y]
    }




}