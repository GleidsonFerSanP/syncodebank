SELECT
a.data AS dataAtendimento,
a.concluido,
r.acuidadeauditiva,
r.acuidadevisual,
r.alteracoesdafala,
posicaoortostatica,
r.sentado,
r.estadoemocional,
r.graudeconsciencia,
r.grauorientacao,
r.responde,
r.tipoderespiracao,
r.quantidade,
r.seracao,
r.tosse,
p.nome AS nomeProfissional,
d.paciente_id AS paciente_id,
pa.nome AS nomepaciente
 FROM hcc_atendimento AS a
 LEFT JOIN hcc_relatorio AS r ON r.id = a.relatorio_id
 INNER JOIN hcc_profissional AS p ON p.id = profissional_id
 INNER JOIN hcc_demanda AS d ON d.id = demanda_id
 INNER JOIN hcc_paciente AS pa ON pa.id = paciente_id

