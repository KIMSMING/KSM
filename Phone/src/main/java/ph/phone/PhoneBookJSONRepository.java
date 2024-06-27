package ph.phone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.List;

public class PhoneBookJSONRepository implements IPhoneBookRepository<IPhoneBook> {
    private String fileName;

    public PhoneBookJSONRepository(String fileName) {
        this.fileName = fileName;
    }

    public IPhoneBook getObjsctFromJson(JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            throw new Exception("Error : Input JsonObject is null");
        }
        IPhoneBook object = new PhoneBook();
        object.setId((Long) jsonObject.get("id"));
        object.setName((String) jsonObject.get("name"));
        object.setGroup((EPhoneGroup.valueOf((String) jsonObject.get("group"))));
        object.setPhoneNumber((String) jsonObject.get("phoneNumber"));
        object.setEmail((String) jsonObject.get("email"));
        return object;
    }

    public JSONObject getJsonFromObject(IPhoneBook object) throws Exception {
        if (object == null) {
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
        if (listData == null || listData.size() <= 0) {
            return false;
        }
        JSONArray jsonArray = new JSONArray();
        for (IPhoneBook iPhoneBook : listData) {
            JSONObject jobj = new JSONObject();
//            jobj.put("id", iPhoneBook.getId());
//            jobj.put("name", iPhoneBook.getName());
//            jobj.put("group", iPhoneBook.getGroup());
//            jobj.put("phoneNumber", iPhoneBook.getPhoneNumber());
//            jobj.put("email", iPhoneBook.getEmail());
            jobj = getJsonFromObject(iPhoneBook);
            jsonArray.add(jobj);
        }
        JSONObject jroot = new JSONObject();
        jroot.put("root", jsonArray);

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
            return false; // 파일이 없을때 실행하면 예외 없도록 처리함
        }
        FileReader reader = new FileReader(file, Charset.defaultCharset());
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        reader.close();

        JSONArray jsonArray = (JSONArray) jsonObject.get("root");
        listData.clear();
        for (Object obj : jsonArray) {
            JSONObject element = (JSONObject) obj;
//            Long id = (Long) element.get("id");
//            String name = (String) element.get("name");
//            EPhoneGroup group = (EPhoneGroup) element.get("group");
//            String phoneNumber = (String) element.get("phoneNumber");
//            String email = (String) element.get("email");
//            listData.add(new PhoneBook(id, name, group, phoneNumber, email));
            listData.add(this.getObjsctFromJson(element));
        }
        return true;
    }
}
