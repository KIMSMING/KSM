package ph.phone;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookRepositoryTests {
    public PhoneBookRepositoryTests() throws ParseException {
    }

    @Test
    public void jsonRepositoryTest() throws Exception{
        PhoneBookJSONRepository repository = new PhoneBookJSONRepository("data.json");

        String json = "{\"phoneNumber\":\"010-0000-0000\", \"name\":\"이말자\",\"id\":7,\"email\":\"asdfqwe@asd.com\",\"group\":\"Families\"}";
        JSONParser jsonParser = new JSONParser();
        IPhoneBook object = null;
        // String 문자열을 JSON 객체로 변환
        Object obj = jsonParser.parse(json);
        // JSON 객체를 Account 객체로 변환
        object = repository.getObjsctFromJson((JSONObject)obj);
        assertThat(object.getId()).isEqualTo(7);
        assertThat(object.getName()).isEqualTo("이말자");
        assertThat(object.getGroup()).isEqualTo(EPhoneGroup.Jobs);
        assertThat(object.getPhoneNumber()).isEqualTo("010-0000-0000");
        assertThat(object.getEmail()).isEqualTo("asdfqwe@asd.com");

        IPhoneBook iPhoneBook2 = new PhoneBook();
        iPhoneBook2.setId(12L);
        iPhoneBook2.setName("홍길동");
        iPhoneBook2.setGroup(EPhoneGroup.Hobbies);
        iPhoneBook2.setPhoneNumber("1111-2134");
        iPhoneBook2.setEmail("asdqwegvgg@asd.com");
        JSONObject jobject = repository.getJsonFromObject((iPhoneBook2));
        assertThat((Long)jobject.get("id")).isEqualTo(71L);
        assertThat((String)jobject.get("Name")).isEqualTo("자우");
        assertThat((String)jobject.get("Group")).isEqualTo("Hobbies");
        assertThat((String)jobject.get("PhoneNumber")).isEqualTo("1111-2222");
        assertThat((String)jobject.get("Email")).isEqualTo("asdv@asd.com");
    }

}
