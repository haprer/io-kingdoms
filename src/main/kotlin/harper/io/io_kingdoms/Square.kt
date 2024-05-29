package harper.io.io_kingdoms

class Square {

    enum class Type {
        DEFAULT,
        WALL,
        GATE,
    }

    private var type: Type = Type.DEFAULT

    init {;
    }


    fun getType(): Type {
        return type
    }

}