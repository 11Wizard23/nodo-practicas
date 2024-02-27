SELECT
    concat(a.first_name, " ", a.last_name) as actor
FROM
    `movies` as m
    join actor_movie as am on am.movie_id = m.id
    join actors as a on a.id = am.actor_id
WHERE
    m.title like 'La Guerra de las galaxias: Episodio VI'