export const BASE_URL = import.meta.env.VITE_BACKEND_URL ?? "http://localhost:8080";
//pega o valor da variavel de ambiente, se não existir variavel de ambiente com esse nome
//por padrão utiliza o localhosto8080
//um macete pro frontend pege o valor local caso não tenha instalado o frontend em algum lugar que  tenha a variavel de ambiente