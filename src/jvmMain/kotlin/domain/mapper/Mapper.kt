package domain.mapper


interface Mapper <INPUT, OUTPUT> {
    fun map (input: INPUT):OUTPUT
    fun mapSingle(input: List<INPUT>): List<OUTPUT>{
        return input.map(::map)
    }
}