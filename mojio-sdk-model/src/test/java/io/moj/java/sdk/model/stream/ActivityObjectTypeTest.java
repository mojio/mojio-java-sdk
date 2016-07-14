package io.moj.java.sdk.model.stream;

import com.google.common.collect.ImmutableMap;
import io.moj.java.sdk.model.enums.EnumTest;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by skidson on 2016-07-08.
 */
public class ActivityObjectTypeTest extends EnumTest<ActivityObjectType> {

    @Override
    public Map<String, ActivityObjectType> getMapping() {
        return new ImmutableMap.Builder<String, ActivityObjectType>()
                .put("Leave", ActivityObjectType.LEAVE)
                .put("Arrive", ActivityObjectType.ARRIVE)
                .put("Undo", ActivityObjectType.UNDO)
                .put("Offer", ActivityObjectType.OFFER)
                .put("Accept", ActivityObjectType.ACCEPT)
                .put("Add", ActivityObjectType.ADD)
                .put("Block", ActivityObjectType.BLOCK)
                .put("Create", ActivityObjectType.CREATE)
                .put("Delete", ActivityObjectType.DELETE)
                .put("Follow", ActivityObjectType.FOLLOW)
                .put("Ignore", ActivityObjectType.IGNORE)
                .put("Invite", ActivityObjectType.INVITE)
                .put("Reject", ActivityObjectType.REJECT)
                .put("Question", ActivityObjectType.QUESTION)
                .put("Announce", ActivityObjectType.ANNOUNCE)
                .put("Travel ", ActivityObjectType.TRAVEL)
                .put("Listen", ActivityObjectType.LISTEN)
                .put("Read", ActivityObjectType.READ)
                .put("View", ActivityObjectType.VIEW)
                .put("Join", ActivityObjectType.JOIN)
                .put("Remove", ActivityObjectType.REMOVE)
                .put("TentativeAccept", ActivityObjectType.TENTATIVE_ACCEPT)
                .put("TentativeReject", ActivityObjectType.TENTATIVE_REJECT)
                .put("Dislike", ActivityObjectType.DISLIKE)
                .put("Flag", ActivityObjectType.FLAG)
                .put("Like", ActivityObjectType.LIKE)
                .put("Move", ActivityObjectType.MOVE)
                .put("Update", ActivityObjectType.UPDATE)
                .build();
    }

    @Test
    @Override
    public void testFromKey() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testFromKey();
    }

    @Test
    @Override
    public void testFromKey_invalid() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testFromKey_invalid();
    }

    @Test
    @Override
    public void testGetKey() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testGetKey();
    }

    @Test
    @Override
    public void testValues() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testValues();
    }
}
