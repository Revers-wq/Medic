package com.example.medic;

import org.junit.Assert;
import org.junit.Test;

import com.example.medic.Logic.SwitchScreen;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void fillQueaeTest() {
        String[] mainText  = {"Анализы", "Уведомления", "Мониторинг"};
        String[] text = {"Экспресс сбор и получение проб", "Вы быстро узнаете о результатах", "Наши врачи всегда наблюдают за вашими показателями здоровья"};
        int[] imagId={R.drawable.screen1,R.drawable.screen2, R.drawable.screen3};
        SwitchScreen switchScreen = new SwitchScreen();
        switchScreen.FillQueae();
        for(int i =0; i< mainText.length;i++)
        {
                Assert.assertArrayEquals(new String[]{mainText[i], text[i], ""+imagId[i]}, switchScreen.getQueae());
        }
    }
    @Test
    public void getQueaeTest() {
        String[] mainText  = {"Анализы", "Уведомления", "Мониторинг"};
        String[] text = {"Экспресс сбор и получение проб", "Вы быстро узнаете о результатах", "Наши врачи всегда наблюдают за вашими показателями здоровья"};
        int[] imagId={R.drawable.screen1,R.drawable.screen2, R.drawable.screen3};
        SwitchScreen switchScreen = new SwitchScreen();
        for(int i =0; i>3;i++)
        {
            Assert.assertArrayEquals(new String[]{mainText[i], text[i], ""+imagId[i]}, switchScreen.getQueae());
        }
    }
    @Test
    public void getTextViewStringTest() {
        SwitchScreen switchScreen = new SwitchScreen();
        int size =3;
        for(int i =size; i>1;i++)
        {
            if(i==3) {
                Assert.assertEquals("Пропустить", switchScreen.getTextViewString(i));
            }
            if(i==2) {
                Assert.assertEquals("Пропустить", switchScreen.getTextViewString(i));
            }
        }
    }
    @Test
    public void getTextViewStringLastTest() {
        SwitchScreen switchScreen = new SwitchScreen();
        int size =1;
        Assert.assertEquals("Завершить", switchScreen.getTextViewString(size));
    }
    @Test
    public void getFinis() {
        SwitchScreen switchScreen = new SwitchScreen();

        Assert.assertEquals(true,switchScreen.FinishActivity());
    }
}

