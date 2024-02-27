SELECT
    ep.title,
    GROUP_CONCAT(concat(ac.first_name, " ", ac.last_name)) as actores
FROM
    episodes as ep
    join actor_episode as ae on ep.id = ae.episode_id
    join actors as ac on ac.id = ae.actor_id
group BY
    ep.title