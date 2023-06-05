package demo.jackson.kotlin

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.ObjectIdGenerators

@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator::class,
    property = "id",
    scope = Tree::class,
)
data class Tree(
    val id: Int,
    var fruits: MutableList<Fruit> = mutableListOf(),
)

@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator::class,
    property = "id",
    scope = Fruit::class,
)
data class Fruit(
    @JsonProperty("id")
    val id: Int,
    var calories: List<Calories> = emptyList(),
) {
    @JsonBackReference("id")
    var tree: Tree? = null
}

@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator::class,
    property = "id",
    scope = Calories::class,
)
data class Calories(
    val id: Int,
) {
    var fruit: Fruit? = null
}
