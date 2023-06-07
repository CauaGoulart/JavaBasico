--=================ATIVIDADE=========================

--1. Selecionar todos os registros e atributos da entidade cargo.
select * from cargo c;

--2. Selecionar nome  e a quantidade de vereadores da entidade cidade, 
--ordenado pelo nome da cidade.

select nome,qt_vereadores from cidade order by nome;

--3. Selecionar nome e a quantidade de vereadores da entidade cidade, 
--somente das cidades que possuem mais de 9 vereadores.

select nome,qt_vereadores from cidade where qt_vereadores > 9;

--4. Selecionar quantas cidades possuem mais de 9 vereadores.
select count(*) as quantidade_cidades from cidade where qt_vereadores >= 9;

--5. Selecionar a quantidade máxima de vereadores que uma cidade possui.
select max(qt_vereadores) as quantidade_maxima_vereadores from cidade; 

--6. Selecionar o nome da cidade que possui mais vereadores.
select nome from cidade where qt_vereadores = (select max(qt_vereadores) from cidade) 
;

--7. Selecionar o nome dos candidatos a prefeito ordenados pelo nome.
select nome from candidato where cargo = 1 order by nome;

--8. Selecionar o nome dos candidatos a vereador que possuem "maria" 
--no nome ordenados pelo nome.
select nome from candidato where cargo = 2 and nome like '%MARIA%' order by nome;

--9. Selecionar o nome dos candidatos a vereador que 
--iniciam com 'Y' - ordenado pelo nome.
select nome from candidato where cargo = 2 and nome like 'Y%' order by nome;

--10. Selecionar o nome dos candidatos a prefeito de cada cidade, 
--ordenado pelo nome da cidade e em seguida pelo nome do candidato.
select c.nome,ca.nome from cidade c inner join candidato ca 
on c.id = ca.cidade and ca.cargo = 1 order by c.nome,ca.nome;

--11. Selecionar o nome dos candidatos a prefeito da cidade de 
--'TUBARÃO', ordenado pelo nome do candidato.
select nome from candidato where cargo = 1 and cidade = 274 order by nome;

--12. Selecionar o nome dos candidatos a prefeito da cidade 
--que tem o maior número de eleitores
select nome from candidato where candidato.cidade = 
(select id from cidade where qt_eleitores = (select max(qt_eleitores) 
from cidade )); 

--13. Selecionar a quantidade de candidatos a vereador 
--da cidade de 'TUBARÃO’.
select count(*) as quantidade_vereador
from candidato c
inner join cidade on cidade.id = c.cidade and cidade.nome = 'TUBARÃO'
where cargo = 2;

--14. Selecionar a quantidade de candidatos a vereador de cada cidade, 
--ordenado pelo nome da cidade.
select c.nome as nome_cidade, COUNT(*) as quantidade_vereador
from cidade c 
inner join candidato ca on c.id = ca.cidade
inner join cargo on cargo.id = ca.cargo and cargo.nome = 'Vereador'
group by c.nome 
order by c.nome;

--15. Selecionar a quantidade de votos nulos e brancos para prefeito e para vereador da
--cidade de Tubarão.
select cargo.nome, sum(brancos) as brancos ,sum(nulos) as nulos
from voto_invalido vi 
inner join cidade on vi.cidade = cidade.id and cidade.nome = 'TUBARÃO'
inner join cargo on cargo.id = vi.cargo
group by cargo.nome;

--16. Selecionar a quantidade de votos INVÁLIDOS (BRANCOS + NULOS) para
--prefeito da cidade de Tubarão.
   select SUM(brancos + nulos) as invalidos
from voto_invalido vi
inner join cidade on vi.cidade = cidade.id and cidade.nome = 'TUBARÃO'
inner join cargo on cargo.id = vi.cargo and cargo.nome = 'Prefeito'

--17. Selecionar a quantidade de votos válidos para cada candidato 
--a prefeito da cidade de Tubarão, ordenados pela maior quantidade 
--de votos.
select candidato.nome, voto.voto 
from voto 
inner join candidato on candidato.id = voto.candidato
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
order by voto.voto desc;

--18. Selecionar a quantidade de votos válidos para CADA candidato a vereador da
--cidade de Tubarão ordenados pela maior quantidade de votos.
select candidato.nome, voto.voto 
from voto 
inner join candidato on candidato.id = voto.candidato
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Vereador'
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
order by voto.voto desc;

--19. Selecionar a maior quantidade de votos para prefeito 
--de cada cidade.

select cidade.nome, max(voto.voto)
from voto 
inner join candidato on candidato.id = voto.candidato 
inner join cidade on cidade.id = candidato.cidade
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
group by cidade.nome;

--20. Selecionar os partidos e a quantidade de votos de cada 
--um na cidade de Tubarão ordenados pela maior quantidade de votos.
select partido.sigla, sum(voto.voto) as votos
from voto 
inner join candidato on candidato.id = voto.candidato
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join partido on partido.id = candidato.partido 
group by partido.sigla 
order by votos desc;

--21. Selecionar a quantidade de votos registrados para prefeito 
--na cidade de tubarão. Os votos registrados são considerados os 
--votos para os candidatos,  mais os votos brancos e nulos.

select SUM(voto.voto) as quantidade_votos_registrados
from voto
inner join candidato on voto.candidato = candidato.id
inner join cargo on candidato.cargo = cargo.id and cargo.nome = 'Prefeito'
inner join cidade on candidato.cidade = cidade.id and cidade.nome = 'TUBARÃO';

--22. Selecionar a quantidade de eleitores que deixaram 
--de votar na cidade de tubarão.
select sum(vi.brancos + vi.nulos) as eleitores_faltantes
from cidade ci
inner join voto_invalido vi on ci.id = vi.cidade
where ci.nome = 'TUBARÃO';

 --23. Selecionar a quantidade de eleitores que deixaram de 
 --votar em cada cidade, ordenado pela maior quantidade de faltantes.
select cidade.nome, sum(vi.brancos + vi.nulos) as eleitores_faltantes
from cidade
inner join voto_invalido vi on vi.cidade = cidade.id
group by cidade.id, cidade.nome
order by eleitores_faltantes desc;

--24. Selecionar o percentual de faltantes em cada cidade, 
--ordenado pelo maior percentual.
select ci.nome,
  concat(round((sum(vi.brancos + vi.nulos) * 100.0 / ci.qt_eleitores), 2), '%') as percentual_faltantes
from cidade ci
inner join voto_invalido vi on ci.id = vi.cidade
group by ci.nome, ci.qt_eleitores
order by percentual_faltantes desc;

--25. Selecionar o candidato a prefeito eleito de cada cidade, 
--ordenado pelo nome da cidade.

select cidade.nome as nome_cidade, candidato.nome as nome_candidato
from cidade
inner join candidato on cidade.id = candidato.cidade
inner join voto on candidato.id = voto.candidato
inner join (
  select cidade.id as cidade_id, max(voto.voto) as max_votos
  from cidade
  inner join candidato on cidade.id = candidato.cidade
  inner join voto on candidato.id = voto.candidato
  inner join cargo on candidato.cargo = cargo.id and cargo.nome = 'Prefeito'
  group by cidade.id
) as max_votos_cidade on cidade.id = max_votos_cidade.cidade_id and voto.voto = max_votos_cidade.max_votos
inner join cargo on candidato.cargo = cargo.id and cargo.nome = 'Prefeito'
order by nome_cidade;
