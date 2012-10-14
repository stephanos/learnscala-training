package de.learnscala.beispiele
package date

import org.joda.time.{DateTime => JodaTime, PeriodType, Period}

case class Date(data: JodaTime = new JodaTime()) {

    def -(t: TimeAmount) = new Date(data.minus(t.amount))
    def +(t: TimeAmount) = new Date(data.plus(t.amount))

    override def toString = data.toString
}

case class TimeAmount(amount: Period)

case class TimeUnit(amount: Long) {

    def year = TimeAmount(new Period(amount, PeriodType.years()))
    def years = TimeAmount(new Period(amount, PeriodType.years()))

    def month = TimeAmount(new Period(amount, PeriodType.months()))
    def months = TimeAmount(new Period(amount, PeriodType.months()))

    def week = TimeAmount(new Period(amount, PeriodType.weeks()))
    def weeks = TimeAmount(new Period(amount, PeriodType.weeks()))

    def day = TimeAmount(new Period(amount, PeriodType.days()))
    def days = TimeAmount(new Period(amount, PeriodType.days()))
}

object Date {

    implicit def int2TimeUnit(n: Int): TimeUnit = TimeUnit(n)
    implicit def long2TimeUnit(n: Long): TimeUnit = TimeUnit(n)

    def today = new Date()
    def tomorrow = today + (1 day)
    def yesterday = today - (1 day)
}


object Main extends App {

    import Date._

    println(today + (1 year))
    println(today + 1.year)
    println(tomorrow + 12.months)
    println(yesterday + 42.weeks)
}
