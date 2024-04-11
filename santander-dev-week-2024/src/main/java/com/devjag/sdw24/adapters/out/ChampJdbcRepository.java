package com.devjag.sdw24.adapters.out;

import com.devjag.sdw24.domain.model.Champ;
import com.devjag.sdw24.domain.ports.ChampRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ChampJdbcRepository implements ChampRepository {

    private final JdbcTemplate jdbcTemplate; //@Autowired
    private final RowMapper<Champ> champsrowMapper;

    public ChampJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.champsrowMapper = (rs, rowNum) -> new Champ(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getString("lore"),
                rs.getString("image_url")
        );
    }

    @Override
    public List<Champ> findAll() {
        return jdbcTemplate.query("SELECT * FROM CHAMPIONS", champsrowMapper);
    }

    @Override
    public Optional<Champ> findById(Long id) {
        String sql = "SELECT * FROM CHAMPIONS WHERE id = ?";
        List<Champ> champs = jdbcTemplate.query(sql, champsrowMapper, id);
        return champs.stream().findFirst();
    }
}
