package haprer.com.model

import kotlinx.serialization.Serializable

@Serializable
data class Square(
    var side: Int,
    var occupied: Boolean,
    var occupant: Entity
    )
