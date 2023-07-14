package domain.mapper

/**
 * Created by Mohamed Elgohary on 7/14/2023.
 */

interface Mapper <INPUT, OUTPUT> {
    fun map (input: INPUT):OUTPUT
    fun mapSingle(input: List<INPUT>): List<OUTPUT>{
        return input.map(::map)
    }
}