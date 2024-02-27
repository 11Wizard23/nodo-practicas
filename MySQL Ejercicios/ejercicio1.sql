SELECT
    s.title,
    g.name
FROM
    `series` AS s
    JOIN genres AS g ON s.genre_id = g.id