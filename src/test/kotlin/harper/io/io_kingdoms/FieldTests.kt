package harper.io.io_kingdoms

import org.junit.jupiter.api.Test

class FieldTests {

    //test that field creates a set of empty squares
    @Test
    fun squaresInstantiated() {
        val field = Field
        var square = field.getSquare(0,0)
        assert(square.getType() == Square.Type.DEFAULT)
        square = field.getSquare(3,4)
        assert(square.getType() == Square.Type.DEFAULT)
    }

}