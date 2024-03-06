package com.ari.app.data.remote


import com.ari.app.data.model.PokemonDetail
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDetaiResponse(
    @Json(name = "abilities")
    val abilities: List<Ability>,
    @Json(name = "base_experience")
    val baseExperience: Int,
    @Json(name = "cries")
    val cries: Cries,
    @Json(name = "forms")
    val forms: List<Form>,
    @Json(name = "game_indices")
    val gameIndices: List<GameIndice>,
    @Json(name = "height")
    val height: Int,
    @Json(name = "held_items")
    val heldItems: List<HeldItem>,
    @Json(name = "id")
    val id: Int,
    @Json(name = "is_default")
    val isDefault: Boolean,
    @Json(name = "location_area_encounters")
    val locationAreaEncounters: String,
    @Json(name = "moves")
    val moves: List<Move>,
    @Json(name = "name")
    val name: String,
    @Json(name = "order")
    val order: Int,
    @Json(name = "past_abilities")
    val pastAbilities: List<Any>,
    @Json(name = "past_types")
    val pastTypes: List<Any>,
    @Json(name = "species")
    val species: Species,
    @Json(name = "sprites")
    val sprites: Sprites,
    @Json(name = "stats")
    val stats: List<Stat>,
    @Json(name = "types")
    val types: List<Type>,
    @Json(name = "weight")
    val weight: Int
) {
    @JsonClass(generateAdapter = true)
    data class Ability(
        @Json(name = "ability")
        val ability: AbilityData,
        @Json(name = "is_hidden")
        val isHidden: Boolean,
        @Json(name = "slot")
        val slot: Int
    ) {
        @JsonClass(generateAdapter = true)
        data class AbilityData(
            @Json(name = "name")
            val name: String,
            @Json(name = "url")
            val url: String
        )
    }

    @JsonClass(generateAdapter = true)
    data class Cries(
        @Json(name = "latest")
        val latest: String,
        @Json(name = "legacy")
        val legacy: String
    )

    @JsonClass(generateAdapter = true)
    data class Form(
        @Json(name = "name")
        val name: String,
        @Json(name = "url")
        val url: String
    )

    @JsonClass(generateAdapter = true)
    data class GameIndice(
        @Json(name = "game_index")
        val gameIndex: Int,
        @Json(name = "version")
        val version: Version
    ) {
        @JsonClass(generateAdapter = true)
        data class Version(
            @Json(name = "name")
            val name: String,
            @Json(name = "url")
            val url: String
        )
    }

    @JsonClass(generateAdapter = true)
    data class HeldItem(
        @Json(name = "item")
        val item: Item,
        @Json(name = "version_details")
        val versionDetails: List<VersionDetail>
    ) {
        @JsonClass(generateAdapter = true)
        data class Item(
            @Json(name = "name")
            val name: String,
            @Json(name = "url")
            val url: String
        )

        @JsonClass(generateAdapter = true)
        data class VersionDetail(
            @Json(name = "rarity")
            val rarity: Int,
            @Json(name = "version")
            val version: Version
        ) {
            @JsonClass(generateAdapter = true)
            data class Version(
                @Json(name = "name")
                val name: String,
                @Json(name = "url")
                val url: String
            )
        }
    }

    @JsonClass(generateAdapter = true)
    data class Move(
        @Json(name = "move")
        val move: MoveData,
        @Json(name = "version_group_details")
        val versionGroupDetails: List<VersionGroupDetail>
    ) {
        @JsonClass(generateAdapter = true)
        data class MoveData(
            @Json(name = "name")
            val name: String,
            @Json(name = "url")
            val url: String
        )

        @JsonClass(generateAdapter = true)
        data class VersionGroupDetail(
            @Json(name = "level_learned_at")
            val levelLearnedAt: Int,
            @Json(name = "move_learn_method")
            val moveLearnMethod: MoveLearnMethod,
            @Json(name = "version_group")
            val versionGroup: VersionGroup
        ) {
            @JsonClass(generateAdapter = true)
            data class MoveLearnMethod(
                @Json(name = "name")
                val name: String,
                @Json(name = "url")
                val url: String
            )

            @JsonClass(generateAdapter = true)
            data class VersionGroup(
                @Json(name = "name")
                val name: String,
                @Json(name = "url")
                val url: String
            )
        }
    }

    @JsonClass(generateAdapter = true)
    data class Species(
        @Json(name = "name")
        val name: String,
        @Json(name = "url")
        val url: String
    )

    @JsonClass(generateAdapter = true)
    data class Sprites(
        @Json(name = "back_default")
        val backDefault: String,
        @Json(name = "back_female")
        val backFemale: Any?,
        @Json(name = "back_shiny")
        val backShiny: String,
        @Json(name = "back_shiny_female")
        val backShinyFemale: Any?,
        @Json(name = "front_default")
        val frontDefault: String,
        @Json(name = "front_female")
        val frontFemale: Any?,
        @Json(name = "front_shiny")
        val frontShiny: String,
        @Json(name = "front_shiny_female")
        val frontShinyFemale: Any?,
        @Json(name = "other")
        val other: Other,
        @Json(name = "versions")
        val versions: Versions
    ) {
        @JsonClass(generateAdapter = true)
        data class Other(
            @Json(name = "dream_world")
            val dreamWorld: DreamWorld,
            @Json(name = "home")
            val home: Home,
            @Json(name = "official-artwork")
            val officialArtwork: OfficialArtwork,
            @Json(name = "showdown")
            val showdown: Showdown
        ) {
            @JsonClass(generateAdapter = true)
            data class DreamWorld(
                @Json(name = "front_default")
                val frontDefault: String,
                @Json(name = "front_female")
                val frontFemale: Any?
            )

            @JsonClass(generateAdapter = true)
            data class Home(
                @Json(name = "front_default")
                val frontDefault: String,
                @Json(name = "front_female")
                val frontFemale: Any?,
                @Json(name = "front_shiny")
                val frontShiny: String,
                @Json(name = "front_shiny_female")
                val frontShinyFemale: Any?
            )

            @JsonClass(generateAdapter = true)
            data class OfficialArtwork(
                @Json(name = "front_default")
                val frontDefault: String,
                @Json(name = "front_shiny")
                val frontShiny: String
            )

            @JsonClass(generateAdapter = true)
            data class Showdown(
                @Json(name = "back_default")
                val backDefault: String,
                @Json(name = "back_female")
                val backFemale: Any?,
                @Json(name = "back_shiny")
                val backShiny: String,
                @Json(name = "back_shiny_female")
                val backShinyFemale: Any?,
                @Json(name = "front_default")
                val frontDefault: String,
                @Json(name = "front_female")
                val frontFemale: Any?,
                @Json(name = "front_shiny")
                val frontShiny: String,
                @Json(name = "front_shiny_female")
                val frontShinyFemale: Any?
            )
        }

        @JsonClass(generateAdapter = true)
        data class Versions(
            @Json(name = "generation-i")
            val generationI: GenerationI,
            @Json(name = "generation-ii")
            val generationIi: GenerationIi,
            @Json(name = "generation-iii")
            val generationIii: GenerationIii,
            @Json(name = "generation-iv")
            val generationIv: GenerationIv,
            @Json(name = "generation-v")
            val generationV: GenerationV,
            @Json(name = "generation-vi")
            val generationVi: GenerationVi,
            @Json(name = "generation-vii")
            val generationVii: GenerationVii,
            @Json(name = "generation-viii")
            val generationViii: GenerationViii
        ) {
            @JsonClass(generateAdapter = true)
            data class GenerationI(
                @Json(name = "red-blue")
                val redBlue: RedBlue,
                @Json(name = "yellow")
                val yellow: Yellow
            ) {
                @JsonClass(generateAdapter = true)
                data class RedBlue(
                    @Json(name = "back_default")
                    val backDefault: String,
                    @Json(name = "back_gray")
                    val backGray: String,
                    @Json(name = "back_transparent")
                    val backTransparent: String,
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_gray")
                    val frontGray: String,
                    @Json(name = "front_transparent")
                    val frontTransparent: String
                )

                @JsonClass(generateAdapter = true)
                data class Yellow(
                    @Json(name = "back_default")
                    val backDefault: String,
                    @Json(name = "back_gray")
                    val backGray: String,
                    @Json(name = "back_transparent")
                    val backTransparent: String,
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_gray")
                    val frontGray: String,
                    @Json(name = "front_transparent")
                    val frontTransparent: String
                )
            }

            @JsonClass(generateAdapter = true)
            data class GenerationIi(
                @Json(name = "crystal")
                val crystal: Crystal,
                @Json(name = "gold")
                val gold: Gold,
                @Json(name = "silver")
                val silver: Silver
            ) {
                @JsonClass(generateAdapter = true)
                data class Crystal(
                    @Json(name = "back_default")
                    val backDefault: String,
                    @Json(name = "back_shiny")
                    val backShiny: String,
                    @Json(name = "back_shiny_transparent")
                    val backShinyTransparent: String,
                    @Json(name = "back_transparent")
                    val backTransparent: String,
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_shiny")
                    val frontShiny: String,
                    @Json(name = "front_shiny_transparent")
                    val frontShinyTransparent: String,
                    @Json(name = "front_transparent")
                    val frontTransparent: String
                )

                @JsonClass(generateAdapter = true)
                data class Gold(
                    @Json(name = "back_default")
                    val backDefault: String,
                    @Json(name = "back_shiny")
                    val backShiny: String,
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_shiny")
                    val frontShiny: String,
                    @Json(name = "front_transparent")
                    val frontTransparent: String
                )

                @JsonClass(generateAdapter = true)
                data class Silver(
                    @Json(name = "back_default")
                    val backDefault: String,
                    @Json(name = "back_shiny")
                    val backShiny: String,
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_shiny")
                    val frontShiny: String,
                    @Json(name = "front_transparent")
                    val frontTransparent: String
                )
            }

            @JsonClass(generateAdapter = true)
            data class GenerationIii(
                @Json(name = "emerald")
                val emerald: Emerald,
                @Json(name = "firered-leafgreen")
                val fireredLeafgreen: FireredLeafgreen,
                @Json(name = "ruby-sapphire")
                val rubySapphire: RubySapphire
            ) {
                @JsonClass(generateAdapter = true)
                data class Emerald(
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_shiny")
                    val frontShiny: String
                )

                @JsonClass(generateAdapter = true)
                data class FireredLeafgreen(
                    @Json(name = "back_default")
                    val backDefault: String,
                    @Json(name = "back_shiny")
                    val backShiny: String,
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_shiny")
                    val frontShiny: String
                )

                @JsonClass(generateAdapter = true)
                data class RubySapphire(
                    @Json(name = "back_default")
                    val backDefault: String,
                    @Json(name = "back_shiny")
                    val backShiny: String,
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_shiny")
                    val frontShiny: String
                )
            }

            @JsonClass(generateAdapter = true)
            data class GenerationIv(
                @Json(name = "diamond-pearl")
                val diamondPearl: DiamondPearl,
                @Json(name = "heartgold-soulsilver")
                val heartgoldSoulsilver: HeartgoldSoulsilver,
                @Json(name = "platinum")
                val platinum: Platinum
            ) {
                @JsonClass(generateAdapter = true)
                data class DiamondPearl(
                    @Json(name = "back_default")
                    val backDefault: String,
                    @Json(name = "back_female")
                    val backFemale: Any?,
                    @Json(name = "back_shiny")
                    val backShiny: String,
                    @Json(name = "back_shiny_female")
                    val backShinyFemale: Any?,
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_female")
                    val frontFemale: Any?,
                    @Json(name = "front_shiny")
                    val frontShiny: String,
                    @Json(name = "front_shiny_female")
                    val frontShinyFemale: Any?
                )

                @JsonClass(generateAdapter = true)
                data class HeartgoldSoulsilver(
                    @Json(name = "back_default")
                    val backDefault: String,
                    @Json(name = "back_female")
                    val backFemale: Any?,
                    @Json(name = "back_shiny")
                    val backShiny: String,
                    @Json(name = "back_shiny_female")
                    val backShinyFemale: Any?,
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_female")
                    val frontFemale: Any?,
                    @Json(name = "front_shiny")
                    val frontShiny: String,
                    @Json(name = "front_shiny_female")
                    val frontShinyFemale: Any?
                )

                @JsonClass(generateAdapter = true)
                data class Platinum(
                    @Json(name = "back_default")
                    val backDefault: String,
                    @Json(name = "back_female")
                    val backFemale: Any?,
                    @Json(name = "back_shiny")
                    val backShiny: String,
                    @Json(name = "back_shiny_female")
                    val backShinyFemale: Any?,
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_female")
                    val frontFemale: Any?,
                    @Json(name = "front_shiny")
                    val frontShiny: String,
                    @Json(name = "front_shiny_female")
                    val frontShinyFemale: Any?
                )
            }

            @JsonClass(generateAdapter = true)
            data class GenerationV(
                @Json(name = "black-white")
                val blackWhite: BlackWhite
            ) {
                @JsonClass(generateAdapter = true)
                data class BlackWhite(
                    @Json(name = "animated")
                    val animated: Animated,
                    @Json(name = "back_default")
                    val backDefault: String,
                    @Json(name = "back_female")
                    val backFemale: Any?,
                    @Json(name = "back_shiny")
                    val backShiny: String,
                    @Json(name = "back_shiny_female")
                    val backShinyFemale: Any?,
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_female")
                    val frontFemale: Any?,
                    @Json(name = "front_shiny")
                    val frontShiny: String,
                    @Json(name = "front_shiny_female")
                    val frontShinyFemale: Any?
                ) {
                    @JsonClass(generateAdapter = true)
                    data class Animated(
                        @Json(name = "back_default")
                        val backDefault: String,
                        @Json(name = "back_female")
                        val backFemale: Any?,
                        @Json(name = "back_shiny")
                        val backShiny: String,
                        @Json(name = "back_shiny_female")
                        val backShinyFemale: Any?,
                        @Json(name = "front_default")
                        val frontDefault: String,
                        @Json(name = "front_female")
                        val frontFemale: Any?,
                        @Json(name = "front_shiny")
                        val frontShiny: String,
                        @Json(name = "front_shiny_female")
                        val frontShinyFemale: Any?
                    )
                }
            }

            @JsonClass(generateAdapter = true)
            data class GenerationVi(
                @Json(name = "omegaruby-alphasapphire")
                val omegarubyAlphasapphire: OmegarubyAlphasapphire,
                @Json(name = "x-y")
                val xY: XY
            ) {
                @JsonClass(generateAdapter = true)
                data class OmegarubyAlphasapphire(
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_female")
                    val frontFemale: Any?,
                    @Json(name = "front_shiny")
                    val frontShiny: String,
                    @Json(name = "front_shiny_female")
                    val frontShinyFemale: Any?
                )

                @JsonClass(generateAdapter = true)
                data class XY(
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_female")
                    val frontFemale: Any?,
                    @Json(name = "front_shiny")
                    val frontShiny: String,
                    @Json(name = "front_shiny_female")
                    val frontShinyFemale: Any?
                )
            }

            @JsonClass(generateAdapter = true)
            data class GenerationVii(
                @Json(name = "icons")
                val icons: Icons,
                @Json(name = "ultra-sun-ultra-moon")
                val ultraSunUltraMoon: UltraSunUltraMoon
            ) {
                @JsonClass(generateAdapter = true)
                data class Icons(
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_female")
                    val frontFemale: Any?
                )

                @JsonClass(generateAdapter = true)
                data class UltraSunUltraMoon(
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_female")
                    val frontFemale: Any?,
                    @Json(name = "front_shiny")
                    val frontShiny: String,
                    @Json(name = "front_shiny_female")
                    val frontShinyFemale: Any?
                )
            }

            @JsonClass(generateAdapter = true)
            data class GenerationViii(
                @Json(name = "icons")
                val icons: Icons
            ) {
                @JsonClass(generateAdapter = true)
                data class Icons(
                    @Json(name = "front_default")
                    val frontDefault: String,
                    @Json(name = "front_female")
                    val frontFemale: Any?
                )
            }
        }
    }

    @JsonClass(generateAdapter = true)
    data class Stat(
        @Json(name = "base_stat")
        val baseStat: Int,
        @Json(name = "effort")
        val effort: Int,
        @Json(name = "stat")
        val stat: StatData
    ) {
        @JsonClass(generateAdapter = true)
        data class StatData(
            @Json(name = "name")
            val name: String,
            @Json(name = "url")
            val url: String
        )
    }

    @JsonClass(generateAdapter = true)
    data class Type(
        @Json(name = "slot")
        val slot: Int,
        @Json(name = "type")
        val type: TypeData
    ) {
        @JsonClass(generateAdapter = true)
        data class TypeData(
            @Json(name = "name")
            val name: String,
            @Json(name = "url")
            val url: String
        )
    }

    fun toPokemonDetail(): PokemonDetail {
        return PokemonDetail(
            id = id,
            name = name,
            imageUrl = id.asPokemonImageUrl(),
            height = height * 10,
            weight = weight * 0.1f,
        )
    }
}