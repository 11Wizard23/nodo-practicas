SELECT
    g.name,
    COUNT(m.id)
from
    genres as g
    join movies as m on m.genre_id = g.id
group by
    g.name