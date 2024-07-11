package data.data.Category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoryControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void CategoryTest() {
        String url = "http://localhost:" + port;
        CategoryDto requestInsert = CategoryDto.builder().build();
        ResponseEntity<CategoryDto> responseInsert = this.testRestTemplate.postForEntity(url + "/ct"
                ,requestInsert, CategoryDto.class);
        assertThat(responseInsert).isNotNull();
        assertThat(responseInsert.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        CategoryDto requestInsert2 = CategoryDto.builder().name("RestFulAPI Input").build();
        ResponseEntity<CategoryDto> responseInsert2 = this.testRestTemplate.postForEntity(url + "/ct"
                ,requestInsert2, CategoryDto.class);
        assertThat(responseInsert2).isNotNull();
        assertThat(responseInsert2.getStatusCode()).isEqualTo(HttpStatus.OK);
        System.out.println("responseInsert2.getBody().getId() = " + responseInsert2.getBody().getId());
        assertThat(responseInsert2.getBody().getName()).isEqualTo("RestFulAPI Input");

        //Category Find Test
        Long insertId = responseInsert2.getBody().getId();
        ResponseEntity<CategoryDto> findEntity = this.testRestTemplate.getForEntity(url + "/ct/" + insertId.toString(), CategoryDto.class);
        assertThat(findEntity).isNotNull();
        assertThat(findEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        ICategory resultFind = findEntity.getBody();
        assertThat(resultFind).isNotNull();
        assertThat(resultFind.getId()).isEqualTo((insertId));
        assertThat(resultFind.getName()).isEqualTo(("RestFulAPI Input"));

        ResponseEntity<CategoryDto> notfindEntity = this.testRestTemplate.getForEntity(url + "/ct/99999999", CategoryDto.class);
        assertThat(notfindEntity).isNotNull();
        assertThat(notfindEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

        //Category Update Test
        ICategory update = CategoryDto.builder().build();
        update.copyFields(resultFind);
        update.setName("NoRest");
        CategoryDto resultObject = this.testRestTemplate.patchForObject(url + "/ct/" + update.getId(), update, CategoryDto.class);
        assertThat(resultObject).isNotNull();
        assertThat(resultObject.getName()).isEqualTo("NoRest");

        //Category Delete Test

        ICategory delete = CategoryDto.builder().id(update.getId()).build();
        this.testRestTemplate.delete(url + "/ct/" + delete.getId(), CategoryDto.class);
        ResponseEntity<CategoryDto> deleteEntity = this.testRestTemplate.getForEntity(url + "/ct/" + insertId.toString(), CategoryDto.class);
        assertThat(deleteEntity).isNotNull();
        assertThat(deleteEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);


    }

}
