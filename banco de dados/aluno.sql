select a.nome as nome_aluno, n.nota, d.nome as disciplina_nome from Aluno as a, Nota as n, Disciplina as d where a.id = n.id_aluno_fk and d.id = n.id_disciplina_fk 