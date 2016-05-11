package io.moj.java.sdk.model.push;

/**
 * Created by skidson on 16-02-18.
 */
public class TestJson {

    public static final String CONDITION = "{\"Property\":\"property\",\"Position\":\"Above\",\"Max\":200.0,\"Min\":120.0,\"TimeProperty\":\"timeProperty\",\"Delay\":\"delay\",\"MinDataPoints\":4,\"Window\":\"window\"}";;
    public static final String TRANSPORT = "{\"TransportType\":\"HttpPost\",\"DeviceRegistrationId\":\"deviceRegistrationId\",\"DeviceToken\":\"deviceToken\",\"AppId\":\"appId\",\"AlertBody\":\"alertBody\",\"AlertSound\":\"alertSound\",\"AlertCategory\":\"alertCategory\",\"Badge\":3,\"Address\":\"address\",\"HostName\":\"hostName\",\"Topic\":\"topic\",\"Port\":1337,\"ConnectionString\":\"connectionString\",\"CollectionName\":\"collectionName\",\"Identifier\":\"Default\",\"HubName\":\"hubName\",\"Callback\":\"callback\",\"ClientId\":\"clientId\",\"UserName\":\"userName\",\"Password\":\"password\"}";
    public static final String OBSERVER = "{\"Key\":\"key\",\"CreatedOn\":\"createdOn\",\"LastModified\":\"lastModified\",\"ExpiryDate\":\"expiryDate\",\"Subject\":\"subject\",\"Type\":\"vehicle\",\"Fields\":[\"field1\",\"field2\"],\"Transports\":[{\"TransportType\":\"HttpPost\",\"DeviceRegistrationId\":\"deviceRegistrationId\",\"DeviceToken\":\"deviceToken\",\"AppId\":\"appId\",\"AlertBody\":\"alertBody\",\"AlertSound\":\"alertSound\",\"AlertCategory\":\"alertCategory\",\"Badge\":3,\"Address\":\"address\",\"HostName\":\"hostName\",\"Topic\":\"topic\",\"Port\":1337,\"ConnectionString\":\"connectionString\",\"CollectionName\":\"collectionName\",\"Identifier\":\"Default\",\"HubName\":\"hubName\",\"Callback\":\"callback\",\"ClientId\":\"clientId\",\"UserName\":\"userName\",\"Password\":\"password\"}],\"Conditions\":[{\"Delay\":\"2.03:04:05.0000\",\"MinDataPoints\":1},{\"Delay\":\"6.07:08:09.0000\"},{\"Property\":\"Property\"},{\"Window\":\"0.03:06:09.0000\"}]}";
    public static final String OBSERVER_REQUEST = "{\"Key\":\"key\",\"Subject\":\"subject\",\"Fields\":[\"LastContactTime\",\"LastContactTime\"],\"PropertyChanged\":\"Property\",\"Threshold\":{\"Property\":\"Property\",\"Position\":\"Above\",\"Max\":2.0,\"Min\":1.0},\"Debounce\":{\"Delay\":\"2.03:04:05.0000\",\"MinDataPoints\":1},\"Throttle\":{\"TimeProperty\":\"Speed.Value\",\"Window\":\"0.00:01:00.0000\"},\"Transport\":{\"TransportType\":\"Android\",\"DeviceRegistrationId\":\"gcmRegId\"},\"Type\":\"mojio\"}";

}
