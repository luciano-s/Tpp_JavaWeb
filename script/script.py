import sys


def generate_dict(string_data):
    dic = {}
    data = ['id', 'caminho_imagem', 'caminho_trailer','classificacao_ind',
     'descricao', 'episodios', 'nome', 'nota', 'temporadas']
    i = 0
    list_int = ['id','classificacao_ind', 'episodios', 'temporadas']
    for d in data:
        # print(d)
        try:
            if d in list_int:
                dic[d] = int(string_data[i])
            elif d == 'nota':
                dic[d] = float(string_data[i])
            else:
                dic[d] = string_data[i]
        except:
            print('Erro nos dados')
        i +=1 
    return dic


def generate_query(data):
    base_query = f'insert into serie (id, caminho_imagem, caminho_trailer, classificacao_ind, descricao, episodios, nome, nota, temporadas) values({data["id"]}, "{data["caminho_imagem"]}", "{data["caminho_trailer"]}",{data["classificacao_ind"]}, "{data["descricao"]}",{data["episodios"]}, "{data["nome"]}",{data["nota"]}, {data["temporadas"]});\n'
    return base_query


if __name__ == '__main__':
    parameters = sys.argv
    parameters = parameters[1:]
    file_sql = parameters[len(parameters)-1]

    if '-cf' in parameters:
        filename = parameters[1]
        data = []
        with open(filename, "r") as f:
            buff = f.readline()
            data.append(buff.split(','))
    else:
        data = []
        message = 'Insira os valores no formato: id, "caminho_imagem", "caminho_trailer",'
        message += '"classificao_ind", "descricao", episodios, "nome", nota, temporadas'
        print(message)
        buff = input()
        while(buff != '\q'):
            data.append(buff.split(','))
            message = 'Insira os valores no formato id, "caminho_imagem", "caminho_trailer",'
            message += '"classificao_ind" "descricao", episodios, "nome", nota, temporadas'
            print(message)
            buff = input()
    dict_data = []
    for d in data:
        print(d)
        dict_data.append(generate_dict(d))
    with open(file_sql, 'w') as f:
        f.write('use tpp_web;\n')
        for d in dict_data:
            query = generate_query(d)
            f.write(query)

        
