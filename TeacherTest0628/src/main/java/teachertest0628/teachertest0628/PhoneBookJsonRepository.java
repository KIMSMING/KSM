package teachertest0628.teachertest0628;

import com.softagape.sbtest0628.EPhoneGroup;
import com.softagape.sbtest0628.IPhoneBook;
import com.softagape.sbtest0628.IPhoneBookRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.List;

public class PhoneBookJsonRepository implements IPhoneBookRepository<IPhoneBook> {
    private String fileName;
    public PhoneBookJsonRepository(String fileName) {
        this.fileName = fileName;
    }

    public IPhoneBook getObjectFromJson(JSONObject jsonObject) throws Exception {
        if ( jsonObject == null ) {
            throw new Exception("Error : Input jsonObject is null");
        }
        IPhoneBook object = new PhoneBook();
        object.setId( (Long)jsonObject.get("id") );
        object.setName( (String)jsonObject.get("name") );
        object.setGroup( EPhoneGroup.valueOf((String)jsonObject.get("group")) );
        object.setPhoneNumber( (String)jsonObject.get("phoneNumber") );
        object.setEmail( (String)jsonObject.get("email") );
        return object;
    }

    public JSONObject getJsonFromObject(IPhoneBook object) throws Exception {
        if ( object == null ) {
            throw new Exception("Error : Input object is null");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", object.getId());
        jsonObject.put("name", object.getName());
        jsonObject.put("group", object.getGroup().toString());
        jsonObject.put("phoneNumber", object.getPhoneNumber());
        jsonObject.put("email", object.getEmail());
        return jsonObject;
    }

    @Override
    public boolean saveData(List<IPhoneBook> listData) throws Exception {
        if ( listData == null || listData.size() <= 0 ) {
            return false;
        }
        JSONArray jsonArray = new JSONArray();
        for ( IPhoneBook object : listData ) {
            JSONObject jObject = this.getJsonFromObject(object);
            jsonArray.add(jObject);
        }
        JSONObject jroot = new JSONObject();
        jroot.put("root", jsonArray);

        if (fileName == null || fileName.isEmpty()) {
            return false;
        }
        FileWriter fileWriter = new FileWriter(fileName, Charset.defaultCharset());
        fileWriter.write(jroot.toString());
        fileWriter.flush();
        fileWriter.close();
        return true;
    }

    @Override
    public boolean loadData(List<IPhoneBook> listData) throws Exception {
        if ( listData == null ) {
            return false;
        }
        JSONParser parser = new JSONParser();
        File file = new File(fileName);
        if ( !file.exists() ) {
            return true;    // 파일이 없을때도 true 를 리턴하여 실행하도록 처리
        }
        FileReader reader = new FileReader(file, Charset.defaultCharset());
        JSONObject jsonObject = (JSONObject)parser.parse(reader);
        reader.close();

        JSONArray jsonArray = (JSONArray) jsonObject.get("root");
        listData.clear();
        for ( Object obj : jsonArray ) {
            IPhoneBook object = this.getObjectFromJson((JSONObject)obj);
            listData.add(object);
        }
        return true;
    }
}
