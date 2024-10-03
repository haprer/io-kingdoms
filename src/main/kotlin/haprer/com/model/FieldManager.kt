package haprer.com.model

import kotlinx.serialization.Serializable

/**
 * this singleton is responsible for representing the field of the game
 * and most importantly synchronizing all access to it.
 *
 * The current strategy:
 * the field is divided into regions, each with their own lock.
 * For inter-region changes, both region locks are required.
 * To avoid deadlock situations all locks for any given request are (MUST BE)
 * acquired in order from north to south, west to east. (like reading a book)
 * e.g. if four regions are required they will be taken in order NW, NE, SW, SE
 *      Currently, not move can require more than four regions because the maximum move distance is
 *      less than the region width.
 *
 *
 * Regions will be kept small to allow lots of concurrency?
 */
object FieldManager {

    @Serializable
    data class FieldData(val width: Int)

}